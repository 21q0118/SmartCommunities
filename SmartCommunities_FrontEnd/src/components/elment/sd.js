// /**
//  * @description 本地图片转base64方法（兼容APP、H5、小程序）
//  * @param {number} path 图片本地路径
//  * @returns Promise对象
//  */
// const toBase64 = (path) => {
//     return new Promise((resolve, reject) => {
//         // #ifdef APP-PLUS
//         plus.io.resolveLocalFileSystemURL(path, (entry) => {
//             entry.file((file) => {
//                 let fileReader = new plus.io.FileReader()
//                 fileReader.readAsDataURL(file)
//                 fileReader.onloadend = (evt) => {
//                     let base64 = evt.target.result.split(",")[1]
//                     resolve(base64)
//                 }
//             })
//         })
//         // #endif
//         // #ifdef H5
//         uni.request({
//             url: path,
//             responseType: 'arraybuffer',
//             success: (res) => {
//                 resolve(uni.arrayBufferToBase64(res.data))
//             }
//         })
//         // #endif
//         // #ifdef MP-WEIXIN
//         uni.getFileSystemManager().readFile({
//             filePath: path,
//             encoding: 'base64',
//             success: (res) => {
//                 resolve(res.data)
//             }
//         })
//         // #endif
//     })
// }
//
// export default {
//     toBase64
// }
